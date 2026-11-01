
const Legend = () => {
  return (
    <div className="mt-6 flex flex-wrap items-center gap-6 text-sm text-gray-600">
      <div className="flex items-center gap-2">
        <div className="w-4 h-4 bg-blue-600 rounded"></div>
        <span>UEFA Champions League qualification</span>
      </div>
      <div className="flex items-center gap-2">
        <div className="w-4 h-4 bg-orange-500 rounded"></div>
        <span>UEFA Europa League qualification</span>
      </div>
      <div className="flex items-center gap-2">
        <div className="w-4 h-4 bg-pink-500 rounded"></div>
        <span>Relegated to the Championship</span>
      </div>
    </div>
  );
};

export default Legend;