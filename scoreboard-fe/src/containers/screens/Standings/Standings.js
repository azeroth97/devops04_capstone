import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../../../axios/axios";
import Banner from "../../../components/Banner/Banner";
import Legend from "../../../components/Standings/Legend/Legend";
import Ranking from "../../../components/Standings/Ranking/Ranking";
import StandingsHeader from "../../../components/Standings/StandingsHeader/StandingsHeader";
import DropDown from "../../../components/Filter/DropDown/DropDown";
import FilterButton from "../../../components/Filter/FilterButton/FilterButton";
import ResetButton from "../../../components/Filter/ResetButton/ResetButton";
import { nationalLeagues, defaultLeague } from "../../../data/data";


const Standings = () => {
  const { league: leagueAlias } = useParams();
  const navigate = useNavigate();

  const initialLeague = nationalLeagues.find(l => l.alias === leagueAlias) || defaultLeague;

  const [league, setLeague] = useState(initialLeague);
  const [season, setSeason] = useState();
  const [seasons, setSeasons] = useState();
  const [currentSeason, setCurrentSeason] = useState();
  const [infos, setInfos] = useState([]);
  const [defaultSeason, setDefaultSeason] = useState();

  useEffect(() => {
    const fetchSeasons = async () => {
      const response = await api.get(`seasons`);
      const data = response.data
      setSeasons(data);

      const currentSeason = data.reduce((s1, s2) => (s2.id > s1.id ? s2 : s1));
      setSeason(currentSeason);
      setCurrentSeason(currentSeason);
      setDefaultSeason(currentSeason);
    }
    fetchSeasons();
  }, []);

  useEffect(() => {
     if (!season) return;

    const fetchInfos = async () => {
      const response = await api.get(`leagues/${league.id}/seasons/${season.id}`);
      setInfos(response.data);
    }
    fetchInfos();
  }, [league, season]);

  if (!seasons || seasons.length === 0 || !season) return null;

  const handleChangeLeague = (selectedLeague) => {
    const newLeague = nationalLeagues.find(l => l.name === selectedLeague);
    setLeague(newLeague);
    navigate(`/standings/${newLeague.alias}`);
  };

  const handleChangeSeason = (selectedSeason) => {
    setSeason(seasons.find(s=>s.name===selectedSeason));
  };

  const handleReset = () => {
    setLeague(defaultLeague);
    setSeason(defaultSeason);
    navigate(`/standings/${defaultLeague.alias}`);
  };

  return (
    <div>
      <Banner title = "Table"/>
      <div className="main-content">

        {/* Filter */}
        <div className="flex flex-wrap items-center gap-4 mb-6">
          <FilterButton />

          <DropDown
            opts={nationalLeagues.map(league=>league.name)}
            selectedOpt={league.name}
            onChangeOption={handleChangeLeague}
          />

          <DropDown
            opts={seasons.map(season=>season.name)}
            selectedOpt={season.name}
            onChangeOption={handleChangeSeason}
          />

          <ResetButton onClick={handleReset}/>
        </div>

        {/* Standings */}
        <div className="bg-white rounded-lg">
          <div className="overflow-x-auto">
            <table className="w-full">
              <thead>
                <StandingsHeader season={season} currentSeason={currentSeason}/>
              </thead>
              <tbody>
                {infos.map((info) => (<Ranking key={info.rankId} info={[info, season, currentSeason]} />))}
              </tbody>
            </table>
          </div>
        </div>

        <Legend />
      </div>
    </div>
  );
};

export default Standings;