import MatchCard from "../MatchCard/MatchCard";

const MatchWeek = ({ matchDate, matches }) => {
  return (
    <div className="mb-8">
      <div className="flex items-center justify-between mb-4">
        <h3 className="text-xl font-bold text-gray-900">{matchDate}</h3>
      </div>
      <div className="space-y-3">
        {matches.map((match, index) => (
          <MatchCard key={match.matchId} match={match} />
        ))}
      </div>
    </div>
  );
};

export default MatchWeek;