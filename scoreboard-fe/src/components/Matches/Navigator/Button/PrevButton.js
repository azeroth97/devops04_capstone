const PrevButton = ({onClick}) => {
  return (
    <button className="p-2 hover:bg-white rounded-lg transition" onClick={onClick}>
      <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 19l-7-7 7-7" />
      </svg>
    </button>
  );
};

export default PrevButton;