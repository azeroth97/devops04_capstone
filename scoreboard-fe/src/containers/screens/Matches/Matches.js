import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../../../axios/axios";
import Banner from "../../../components/Banner/Banner";
import MatchWeek from "../../../components/Matches/MatchWeek/MatchWeek";
import Navigator from "../../../components/Matches/Navigator/Navigator";
import FilterButton from "../../../components/Filter/FilterButton/FilterButton";
import DropDown from "../../../components/Filter/DropDown/DropDown";
import ResetButton from "../../../components/Filter/ResetButton/ResetButton";
import { nationalLeagues, defaultLeague} from "../../../data/data";


const Matches = () => {
  const { league: leaugeAlias } = useParams();
  const navigate = useNavigate();

  const initialLeague = nationalLeagues.find(l => l.alias === leaugeAlias) || defaultLeague;

  const [league, setLeague] = useState(initialLeague);
  const [season, setSeason] = useState();
  const [seasons, setSeasons] = useState();
  const [week, setWeek] = useState();
  const [weeks, setWeeks] = useState();
  const [infos, setInfos] = useState([]);
  const [defaultSeason, setDefaultSeason] = useState();

  useEffect(() => {
    const fetchSeasons = async () => {
      const response = await api.get(`seasons`);
      const data = response.data
      setSeasons(data);

      const currentSeason = data.reduce((s1, s2) => (s2.id > s1.id ? s2 : s1));
      setSeason(currentSeason);
      setDefaultSeason(currentSeason);
    }
    fetchSeasons();
  }, []);


  useEffect(() => {
    if (!season) return;

    const fetchWeeks = async () => {
      const response = await api.get(`leagues/${league.id}/seasons/${season.id}/weeks`);
      setWeeks(response.data);
    }
    fetchWeeks();
  }, [league, season]);

  
  useEffect(() => {
     if (!season) return;

    const fetchCurrentWeek = async () => {
      const response = await api.get(`leagues/${league.id}/seasons/${season.id}/latest-week`);
      setWeek(response.data);
    }
    fetchCurrentWeek();
  }, [league, season]);


  useEffect(() => {
     if (!season || !week) return;

    const fetchInfos = async () => {
      const response = await api.get(`leagues/${league.id}/seasons/${season.id}/matches/${week.id}`);
      setInfos(response.data);
    }
    fetchInfos();
  }, [league, season, week]);

  if (!infos || infos.length === 0 || !weeks || weeks.length === 0) return null;

  const weekDates = [...new Map(
    infos.map(match => [match.matchDate, match.matchDate2])
  ).entries()].sort((a, b) => new Date(a[1]) - new Date(b[1]));

  const earliestWeekDate = weekDates[0][0];
  
  const latestWeekDate = weekDates[weekDates.length - 1][0];

  const handleChangeLeague = (selectedLeague) => {
    const newLeague = nationalLeagues.find(l => l.name === selectedLeague);
    setLeague(newLeague);
    navigate(`/matches/${newLeague.alias}`);
  };

  const handleChangeSeason = (selectedSeason) => {
    setSeason(seasons.find(s=>s.name===selectedSeason));
  };

  const handleChangeWeek = (selectedWeek) => {
    setWeek(weeks.find(w=>w.name===selectedWeek.replace("MW", "")));
  };

  const handleClickPrev = () => {
    if (week.id > 1) setWeek(weeks.find(w=>w.id===(week.id - 1)));
  };

  const handleClickNext = () => {
    if (week.id < weeks[weeks.length - 1].id) setWeek(weeks.find(w=>w.id===(week.id + 1)));
  };

  const handleReset = () => {
    setLeague(defaultLeague);
    setSeason(defaultSeason);
    navigate(`/matches/${defaultLeague.alias}`);
  };

  return (
    <div>
      <Banner title = "Matches"/>
      <div className="main-content">
        {/* Filters */}
        <div className="flex flex-wrap items-center gap-4 mb-8">
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

          <DropDown 
            opts={weeks.map(week=>week.name)}
            selectedOpt={week.name}
            onChangeOption={handleChangeWeek}
            optional="MW"
          />           

          <ResetButton onClick={handleReset}/>
        </div>

        <Navigator 
          week={week}
          earliestWeekDate={earliestWeekDate}
          latestWeekDate={latestWeekDate}
          onClickPrev={handleClickPrev}
          onClickNext={handleClickNext}
        />

        {weekDates.map(weekDate => (
          <MatchWeek
            key={weekDate[0]}
            matchDate={weekDate[0]}
            matches={infos.filter(match => match.matchDate === weekDate[0])}
          />
        ))}
      </div>
    </div>
  );
};

export default Matches;