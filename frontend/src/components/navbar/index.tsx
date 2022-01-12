import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import './style.css'

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>JopauloMovie</h1>
                    <a href="https://github.com/jopaulo666 " target="_blank" rel="noreferrer">
                        <div className="dsmovie-contact-container">
                            <GithubIcon />
                            <p className="dsmovie-contact-link">/jopaulo666 </p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;