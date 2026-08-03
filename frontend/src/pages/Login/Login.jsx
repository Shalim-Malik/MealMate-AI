import { Link } from "react-router-dom";

function Login() {

    return (

        <div className="container py-5">

            <div className="row justify-content-center">

                <div className="col-lg-5">

                    <div className="card p-5">

                        <h2 className="fw-bold text-success text-center">

                            Welcome Back

                        </h2>

                        <p className="text-center text-muted mb-4">

                            Login to your MealMate AI account

                        </p>

                        <form>

                            <div className="mb-3">

                                <label className="form-label">

                                    Email

                                </label>

                                <input
                                    type="email"
                                    className="form-control"
                                />

                            </div>

                            <div className="mb-4">

                                <label className="form-label">

                                    Password

                                </label>

                                <input
                                    type="password"
                                    className="form-control"
                                />

                            </div>

                            <button
                                className="btn btn-success w-100"
                            >

                                Login

                            </button>

                        </form>

                        <p className="text-center mt-4">

                            Don't have an account?

                            <Link
                                to="/signup"
                                className="text-success fw-bold ms-2"
                            >

                                Sign Up

                            </Link>

                        </p>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Login;