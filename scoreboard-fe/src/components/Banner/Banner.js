
const Banner = ({title}) => {
  return (
    <div className="bg-gradient-to-r from-purple-600 via-blue-500 to-cyan-400 py-16 md:py-5 my-5">
      <div className="max-w-7xl mx-auto">
        <h1 className="py-2 text-4xl md:text-6xl lg:text-5xl font-bold text-white">
          {title}
        </h1>
      </div>
    </div>
  );
};

export default Banner;