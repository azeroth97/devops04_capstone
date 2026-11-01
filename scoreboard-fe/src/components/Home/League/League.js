
const League = ({ league }) => {

  return (
    <a href="#">
      <div className="league-card">
        <span className="league-logo">
          <img src={"logos/" + league.logo}  alt="image.png" />
        </span>

        <span className="league-name" style={{ fontFamily: 'Georgia, serif' }}>
          {league.name}
        </span>
      </div>
    </a>
  );
};

export default League;