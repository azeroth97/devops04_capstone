const Ranking = ({info}) => {
  
  const ranking = info[0];
  const season = info[1];
  const currentSeason = info[2];

  const getFormColor = (result) => {
    switch (result) {
      case 'W':
        return 'bg-green-500';
      case 'D':
        return 'bg-gray-400';
      case 'L':
        return 'bg-red-500';
      default:
        return 'bg-gray-300';
    }
  };

  const getPositionBarColor = (pos) => {
    if (pos <= 4) return 'bg-blue-600';
    if (pos === 5) return 'bg-orange-500';
    if (pos >= 18) return 'bg-pink-500';
    return 'bg-transparent';
  };

  
  return (
    <tr className="hover:bg-gray-50 transition">
      {/* Position with colored bar */}
      <td className="py-2">
        <div className="flex items-center gap-2">
          <div className={`mr-2 w-1 h-10 rounded-r-md ${getPositionBarColor(ranking.position)}`}></div>
          <span className="font-semibold text-gray-900">{ranking.position}</span>
        </div>
      </td>

      {/* Position Change Arrow */}
      <td className="py-2 text-center">
        {ranking.positionChange > 0
          && (
          <svg className="w-4 h-4 text-green-500" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 15l7-7 7 7" />
          </svg>
        )}
        {ranking.positionChange < 0
          && (
          <svg className="w-4 h-4 text-red-500" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M19 9l-7 7-7-7" />
          </svg>
        )}
        {(ranking.positionChange === 0 || ranking.positionChange === null)
          && (
          <svg className="w-4 h-4 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M20 12H4" />
          </svg>
        )}
      </td>

      {/* Team */}
      <td className="py-2 pr-60">
        <div className="flex items-center gap-3">
          <img className="w-8 h-8 object-contain" src={ranking.logo || null} alt="logo.png" />
          <span className="font-semibold text-gray-900">{ranking.teamName}</span>
        </div>
      </td>

      {/* Stats */}
      <td className="px-4 py-2 text-center text-gray-700">{ranking.played}</td>
      <td className="px-4 py-2 text-center text-gray-700">{ranking.wins}</td>
      <td className="px-4 py-2 text-center text-gray-700">{ranking.draws}</td>
      <td className="px-4 py-2 text-center text-gray-700">{ranking.losses}</td>
      <td className="px-4 py-2 text-center text-gray-700">{ranking.goalsFor}</td>
      <td className="px-4 py-2 text-center text-gray-700">{ranking.goalsAgainst}</td>
      <td className="px-4 py-2 text-center text-gray-700">{ranking.goalsDiff}</td>
      <td className="px-4 py-2 text-center font-bold text-gray-900">{ranking.points}</td>

      {season.id === currentSeason.id
        && (
        <>
          {/* Form */}
          <td className="px-2 py-2">
            <div className="flex items-center justify-center gap-1">
              {(ranking.formResults ?? "").split("").map((result, idx) => (
                <div
                  key={idx}
                  className={`mx-0.5 w-6 h-6 rounded-full ${getFormColor(result)} flex items-center justify-center text-white text-xs font-semibold`}
                >
                  {result}
                </div>
              ))}
            </div>
          </td>

          {/* Next Opponent */}
          <td className="px-2 py-2 text-center">
            {/* <span className="text-2xl">{nextOpponent}</span> */}
            <img className="w-8 h-8 object-contain" src={ranking.nextOpponentLogo || "/logos/soccer-ball.png"} alt="logo.png" />
          </td>
        </>
      )}
    </tr>
  );
};

export default Ranking;