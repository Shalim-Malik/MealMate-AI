import heroImg from "../../assets/images/hero.png";

function HeroSection() {

    return (

        <section
            className="container-fluid py-5"
            style={{
                minHeight: "90vh",
                background: "#B4E1EB"
            }}
        >

            <div className="container-fluid px-5">

                <div className="row align-items-center">

                    {/* Left Side */}

                    <div className="col-lg-6 pe-lg-5">

                        <h1
                            className="fw-bold"
                            style={{
                                fontSize: "4rem",
                                lineHeight: "1.15"
                            }}
                        >
                            Eat Better.
                            <br />
                            Live Healthier.
                            <br />
                            <span className="text-success">
                                Powered by AI.
                            </span>
                        </h1>

                        <p
                            className="mt-4 mb-5 text-secondary"
                            style={{
                                fontSize: "1.2rem",
                                lineHeight: "1.8"
                            }}
                        >
                            Personalized meal plans, nutrition tracking,
                            AI recommendations and smart grocery lists
                            for a healthier lifestyle.
                        </p>

                        <div className="d-flex flex-wrap gap-3 mb-5">

                            <button className="btn btn-success btn-lg rounded-pill px-5">
                                Get Started
                            </button>

                            <button className="btn btn-outline-dark btn-lg rounded-pill px-5">
                                Watch Demo
                            </button>

                        </div>

                        <div className="row mt-4">

                            <div className="col-4">

                                <h3 className="fw-bold text-success">
                                    50K+
                                </h3>

                                <p className="text-muted">
                                    Meal Plans
                                </p>

                            </div>

                            <div className="col-4">

                                <h3 className="fw-bold text-success">
                                    98%
                                </h3>

                                <p className="text-muted">
                                    Accuracy
                                </p>

                            </div>

                            <div className="col-4">

                                <h3 className="fw-bold text-success">
                                    AI
                                </h3>

                                <p className="text-muted">
                                    Powered
                                </p>

                            </div>

                        </div>

                    </div>

                    {/* Right Side */}

                    <div className="col-lg-6 text-center mt-5 mt-lg-0">

                        <img
                            src={heroImg}
                            alt="MealMate AI"
                            className="img-fluid rounded-5"
                            style={{
                                maxWidth: "90%",
                                boxShadow: "0 30px 60px rgba(0,0,0,.12)"
                            }}
                        />

                    </div>

                </div>

            </div>

        </section>

    );

}

export default HeroSection;