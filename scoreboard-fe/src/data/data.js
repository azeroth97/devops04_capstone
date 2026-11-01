export const leagues = [
    {id: 1, type: "National Leagues", name: "Premier League", logo: "premier-league.png", alias: "premierleague"}
  , {id: 2, type: "National Leagues", name: "La Liga", logo: "laliga.png", alias: "laliga"}
  , {id: 3, type: "National Leagues", name: "Bundesliga", logo: "bundesliga.png", alias: "bundesliga"}
  , {id: 4, type: "National Leagues", name: "Serie A", logo: "serie-a.png", alias: "seriea"}
  , {id: 5, type: "National Leagues", name: "Ligue 1", logo: "ligue-1.png", alias: "ligue1"}
  , {id: 6, type: "European Club Tournaments", name: "Champions League", logo: "champions-league.png", alias: "championsleague"}
  , {id: 7, type: "European Club Tournaments", name: "Europa League", logo: "europa-leauge.png", alias: "europaleauge"}
  , {id: 8, type: "European Club Tournaments", name: "Conference League", logo: "conference-league.png", alias: "conferenceleague"}
];


export const defaultLeague = leagues.find(
  league => league.name === "Premier League"
);

export const nationalLeagues = leagues.filter(
  league => league.type === "National Leagues"
).sort((a, b) => a.id - b.id);

export const europeanLeagues = leagues.filter(
  league => league.type === "European Club Tournaments"
).sort((a, b) => a.id - b.id);