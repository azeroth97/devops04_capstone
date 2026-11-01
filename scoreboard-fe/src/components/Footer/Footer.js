
const Footer = () => {
  return (
    <footer className="bg-white border-t border-gray-200 mt-5">
      {/* Main Footer Content */}
      <div className="max-w-7xl mx-auto px-6 py-12">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {/* Column 1 */}
          <div className="space-y-4">
            <a href="#" className="main-footer">Premier League</a>
            <a href="#" className="main-footer">Fantasy</a>
            <a href="#" className="main-footer">Matches</a>
          </div>

          {/* Column 2 */}
          <div className="space-y-4">
            <a href="#" className="main-footer">Table</a>
            <a href="#" className="main-footer">Statistics</a>
            <a href="#" className="main-footer">Latest News</a>
          </div>

          {/* Column 3 */}
          <div className="space-y-4">
            <a href="#" className="main-footer">Latest Video</a>
            <a href="#" className="main-footer">Clubs</a>
            <a href="#" className="main-footer">Players</a>
          </div>
        </div>
      </div>

      {/* Bottom Footer Bar */}
      <div className="border-t border-gray-200 bg-gray-50">
        <div className="max-w-7xl mx-auto px-6 py-6">
          <div className="flex flex-col lg:flex-row items-center justify-between gap-4">
            {/* Left Side - Copyright & Links */}
            <div className="flex flex-wrap items-center justify-center lg:justify-start gap-2 text-sm text-gray-600">
              <span className="font-semibold">© FIFA SCOREBOARD 2026</span>
              <span className="hidden lg:inline">•</span>
              <a href="#" className="bottom-footer">Modern Slavery Statement</a> <span>•</span>
              <a href="#" className="bottom-footer">Equality, Diversity and Inclusion Standard</a> <span>•</span>
              <a href="#" className="bottom-footer">Terms of Use</a> <span>•</span>
              <a href="#" className="bottom-footer">Policies</a> <span>•</span>
              <a href="#" className="bottom-footer">Cookie Policy</a> <span>•</span>
              <a href="#" className="bottom-footer">Contact Us</a> <span>•</span>
              <a href="#" className="bottom-footer">Appearance</a> <span>•</span>
              <a href="#" className="bottom-footer">Back To Top</a>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;