import heroImg from "../../assets/images/hero.png";

function HeroSection() {
    return (

        <section
            className="container-fluid py-5"
            style={{ minHeight: "90vh" }}
        >

            <div className="container-fluid px-5">

                <div className="row align-items-center">

                    {/* Left Side */}

                    <div className="col-lg-6">

                        <h1 className="display-3 fw-bold">

                            Eat Smart with

                            <br />

                            <span className="text-success">
                                MealMate AI
                            </span>

                        </h1>

                        <p className="lead mt-4 mb-4">

                            AI-powered personalized meal planning,
                            nutrition tracking and smart grocery lists
                            to help you stay healthy every day.

                        </p>

                        <div className="d-flex gap-3">

                            <button className="btn btn-success btn-lg px-4">

                                Get Started →

                            </button>

                            <button className="btn btn-outline-success btn-lg px-4">

                                Login

                            </button>

                        </div>

                    </div>

                    {/* Right Side */}

                    <div className="col-lg-6 text-center mt-5 mt-lg-0">

                        <img
                            src={heroImg}
                            alt="MealMate AI"
                            className="img-fluid rounded-4 shadow"
                            style={{ maxWidth: "85%" }}
                        />

                    </div>

                </div>

            </div>

        </section>

    );
}

export default HeroSection;