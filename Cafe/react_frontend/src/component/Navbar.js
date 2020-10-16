import React from 'react';

function NavBar() {
    return (
        <div>
            <nav>  
                <div className="logo"> React Nav</div>
                <ul className="nav-links">
                    <li><a href="/">Home</a></li>
                    <li><a href="/page1">Page</a></li>
                    <li><a href="/">Home</a></li>
                    <li><a href="/">Home</a></li>
                </ul>
                <i className="fas fa-bars burger"></i>
            </nav>
        </div>
    );
}

export default NavBar;