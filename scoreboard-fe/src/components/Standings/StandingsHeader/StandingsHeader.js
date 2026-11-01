const StandingsHeader = ({season, currentSeason}) => {
  return (
    <tr>
      <th className="table-header pl-4 pr-2 py-3 text-left w-16">Pos</th>
      <th className="table-header px-1 py-3 text-center w-8"></th>
      <th className="table-header pl-2 pr-4 py-3 text-left">Team</th>
      <th className="table-header px-4 py-3 text-center">Pl</th>
      <th className="table-header px-4 py-3 text-center">W</th>
      <th className="table-header px-4 py-3 text-center">D</th>
      <th className="table-header px-4 py-3 text-center">L</th>
      <th className="table-header px-4 py-3 text-center">GF</th>
      <th className="table-header px-4 py-3 text-center">GA</th>
      <th className="table-header px-4 py-3 text-center">GD</th>
      <th className="table-header px-4 py-3 text-center">Pts</th>
      {season.id === currentSeason.id
        && (
        <>
          <th className="table-header px-2 py-3 text-center">Form</th>
          <th className="table-header px-2 py-3 text-center">Next</th>
        </>
      )}

    </tr>
  );
};

export default StandingsHeader;