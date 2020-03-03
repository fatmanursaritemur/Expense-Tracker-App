import React, { Component } from 'react';
import AppNav from './AppNav';
import background from './backgroundjpg.jpg'
var sectionStyle = {
    paperContainer: {
        height: 1356,
        backgroundImage: `url(${background})`
    }
  };
class Home extends Component {
    state = {  }
    render() { 
        return (
            
            <div>
            <AppNav/>
            <div style={sectionStyle.paperContainer}>
            <h2 style={{display: 'flex',  justifyContent:'center', alignItems:'center', height: '20vh'}}>
              Welcome to easy expense app !</h2>
              </div>
            
             </div>
          );
    }
}
 
export default Home;