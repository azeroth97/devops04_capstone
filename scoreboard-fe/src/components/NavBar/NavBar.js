import { useState, useEffect, useRef } from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
  const [isMoreOpen, setIsMoreOpen] = useState(false);
  const dropdownRef = useRef(null);

  // Close dropdown if user clicks outside of it
  useEffect(() => {
    const handleClickOutside = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setIsMoreOpen(false);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return (
    <nav className="bg-white border-b border-gray-200 px-6 py-3">
      <div className="flex items-center justify-between max-w-7xl mx-auto">
        {/* Left Section - Menu & Logo */}
        <div className="flex items-center gap-6">
          {/* Hamburger Menu */}
          <button className="p-2 hover:bg-gray-100 rounded">
            <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </button>

          {/* Premier League Logo */}
          <Link to="/" className="flex items-center gap-1">
            <div className="w-10 h-10 flex items-center justify-center text-2xl">⚽</div>
            <span className="font-bold text-xl">Scoreboard</span>
          </Link>
        </div>

        {/* Center Section - Navigation Links */}
        <div className="hidden lg:flex items-center gap-8">
          <Link to="/" className="center-nav">Home</Link>
          <Link to="/matches/league" className="center-nav">Matches</Link>
          <Link to="/standings/league" className="center-nav">Table</Link>
          <Link to="/about" className="center-nav">About</Link>

          {/* More Dropdown */}
          <div className="relative" ref={dropdownRef}>
            <button onClick={() => setIsMoreOpen(!isMoreOpen)} className="flex items-center gap-1 center-nav">More
              <svg className="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M19 9l-7 7-7-7" />
              </svg>
            </button>
            {isMoreOpen && (
              <div className="absolute top-full mt-2 w-48 bg-white border border-gray-200 rounded-lg shadow-lg py-2">
                <p className="block px-4 py-2 hover:bg-gray-100">History</p>
                <p className="block px-4 py-2 hover:bg-gray-100">Awards</p>
                <p className="block px-4 py-2 hover:bg-gray-100">Community</p>
              </div>
            )}
          </div>
        </div>

        {/* Right Section - Icons & Sign In */}
        <div className="flex items-center gap-4">
          {/* Search Icon */}
          <button className="p-2 hover:bg-gray-100 rounded-full">
            <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
            </svg>
          </button>

          {/* Sign In Button */}
          <button className="px-6 py-2 border-2 border-gray-900 rounded-full text-gray-900 font-medium hover:bg-gray-900 hover:text-white transition">
            Sign in
          </button>
        </div>
      </div>
    </nav>
  );
};

export default NavBar;