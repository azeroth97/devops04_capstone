import { Route, Routes } from "react-router-dom";
import Footer from "../../components/Footer/Footer";
import NavBar from "../../components/NavBar/NavBar";
import Home from "../screens/Home/Home";
import Standings from "../screens/Standings/Standings";
import Matches from "../screens/Matches/Matches";
import About from "../screens/About/About";
import "./App.css";
import Login from "../screens/Login/Login";

const App = () => {
  return (
    <div className="min-h-screen flex flex-col bg-gray-100">
      <NavBar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/standings/:league" element={<Standings />} />
        <Route path="/matches/:league" element={<Matches />} />
        <Route path="/about" element={<About />} />
      </Routes>

      <Footer />
    </div>
  );
};

export default App;