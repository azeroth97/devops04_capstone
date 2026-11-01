
const MatchCard = ({ match }) => {
  return (
    <div className="bg-white border border-gray-200 rounded-lg p-4 hover:shadow-md transition">
      <div className="flex items-center justify-between">

        <div className="flex-1 flex items-center justify-between gap-4">
          <div className="flex items-center justify-end gap-3 flex-1">
            <span className="font-semibold text-gray-900 text-right">{match.hostName}</span>
            <div className="w-8 h-8 flex items-center justify-center">
              <img className="w-8 h-8 object-contain" src={match.hostLogo} alt="logo.png" />
            </div>
          </div>

          <div className="flex items-center gap-3 min-w-[80px] justify-center">
            <span className="text-lg font-semibold text-gray-900">{match.hostScore}</span>
            <span className="text-lg font-semibold text-gray-400">-</span>
            <span className="text-lg font-semibold text-gray-900">{match.guestScore}</span>
          </div>

          <div className="flex items-center justify-start gap-3 flex-1">
            <div className="w-8 h-8 flex items-center justify-center">
              <img className="w-8 h-8 object-contain" src={match.guestLogo} alt="logo.png" />
            </div>
            <span className="font-semibold text-gray-900 text-left">{match.guestName}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MatchCard;