
const DropDown = ({opts, selectedOpt, onChangeOption, optional=""}) => {
  return (
    <select
      className="filter filter-dropdown"
      value={optional + selectedOpt}
      onChange={(e) => onChangeOption(e.target.value)}
    >
      {opts.map((opt) => (<option key={opt}>{optional}{opt}</option>))}
    </select>
  );
};

export default DropDown;