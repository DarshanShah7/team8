// import React from "react";
// import {Securities} from './components/pets/Securities';

// const App = () => {
//   return <div>
//     <Securities/>; 
//     </div>;
// };

// export default App;

// App.js or your main component file
import React from "react";
import Login from "./components/pets/Login";
import Registration  from "./components/pets/Registration";
import { BrowserRouter as Router, Route } from "react-router-dom"; // If using React Router
import { Switch } from 'react-router-dom';
import Navbar from "./components/pets/Navbar";
import Securities from "./components/pets/Securities"; // Your existing Securities component

const App = () => {
  return (
    <Router>
      <Navbar />
      <Switch>
      <Route path="/login"><Login/></Route>
      <Route path="/register"><Registration/></Route>
        <Route path="/securities">
          <Securities />
        </Route>
        <Route path="/trades">
          <Securities />
        </Route>
        {/* Define other routes as needed */}
      </Switch>
    </Router>
  );
};

export default App;
