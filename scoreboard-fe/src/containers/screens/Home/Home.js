import Banner from "../../../components/Banner/Banner";
import League from "../../../components/Home/League/League";
import { nationalLeagues, europeanLeagues } from "../../../data/data";

const Home = () => {
  return (
    <div>
      <Banner title = "Leagues"/>
      <div className="main-content">

        {/* National Leagues */}
        <div className="mb-14">
          <h2 className="text-3xl font-bold text-gray-900 mb-6 pb-3 border-b-4 border-purple-600 inline-block">
            National Leagues
          </h2>
          <div className="grid grid-cols-2 gap-4">
            {nationalLeagues.map((league) => (<League key={league.id} league={league}/>))}
          </div>
        </div>

        {/* European Club Tournaments */}
        <div className="mb-14">
          <h2 className="text-3xl font-bold text-gray-900 mb-6 pb-3 border-b-4 border-blue-600 inline-block">
            European Club Tournaments
          </h2>
          <div className="grid grid-cols-2 gap-4">
            {europeanLeagues.map((league) => (<League key={league.id} league={league}/>))}
          </div>
        </div>

      </div>
    </div>
  );
};

export default Home;