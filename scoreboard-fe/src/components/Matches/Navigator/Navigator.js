import PrevButton from "./Button/PrevButton";
import NextButton from "./Button/NextButton";

const Navigator = ({ week, earliestWeekDate, latestWeekDate, onClickPrev, onClickNext}) => {
  return (
    <div className="flex items-center justify-center gap-4 mb-8 bg-gray-50 rounded-lg p-4">
      <PrevButton onClick={onClickPrev} />
      <div className="text-center">
        <h2 className="text-lg font-bold text-gray-900">Matchweek {week.name}</h2>
        <p className="text-sm text-gray-600">{earliestWeekDate} - {latestWeekDate}</p>
      </div>
      <NextButton onClick={onClickNext}/>
    </div>
  );
};

export default Navigator;