import { Link } from "react-router-dom";

function Navbar() {

    return (

        <nav
            className="navbar navbar-expand-lg sticky-top"
            style={{
                background: "rgba(255,255,255,.85)",
                backdropFilter: "blur(20px)",
                boxShadow: "0 8px 30px rgba(0,0,0,.06)",
                padding: "18px 0"
            }}
        >

            <div className="container">

                <Link
                    className="navbar-brand fw-bold fs-3 text-success"
                    to="/"
                >
                    🍃 MealMate AI
                </Link>

                <button
                    className="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNav"
                >

                    <span className="navbar-toggler-icon"></span>

                </button>

                <div
                    className="collapse navbar-collapse"
                    id="navbarNav"
                >

                    <ul className="navbar-nav ms-auto align-items-center">

                        <li className="nav-item mx-2">

                            <Link
                                className="nav-link fw-semibold text-dark"
                                to="/"
                            >
                                Home
                            </Link>

                        </li>

                        <li className="nav-item mx-2">

                            <a
                                className="nav-link fw-semibold text-dark"
                                href="#features"
                            >
                                Features
                            </a>

                        </li>

                        <li className="nav-item mx-2">

                            <Link
                                className="nav-link fw-semibold text-dark"
                                to="/login"
                            >
                                Login
                            </Link>

                        </li>

                        <li className="nav-item ms-3">

                            <Link
                                to="/signup"
                                className="btn btn-success rounded-pill px-4"
                            >
                                Get Started
                            </Link>

                        </li>

                    </ul>

                </div>

            </div>

        </nav>

    );

}

export default Navbar;