function HowItWorks() {

    const steps = [
        {
            number: "01",
            title: "Create Account",
            description:
                "Sign up and create your MealMate AI account in just a few clicks."
        },
        {
            number: "02",
            title: "Set Preferences",
            description:
                "Tell us your goals, diet preference, allergies and lifestyle."
        },
        {
            number: "03",
            title: "Get AI Meal Plan",
            description:
                "Receive personalized meal plans, nutrition insights and grocery lists instantly."
        }
    ];

    return (

        <section className="container py-5">

            <div className="text-center mb-5">

                <h2 className="display-5 fw-bold">

                    How It
                    <span className="text-success">
                        Works
                    </span>

                </h2>

                <p className="text-muted">

                    Get your personalized meal plan in 3 simple steps.

                </p>

            </div>

            <div className="row g-4">

                {steps.map((step, index) => (

                    <div className="col-md-4" key={index}>

                        <div className="card border-0 shadow rounded-4 h-100 p-4 text-center">

                            <div
                                className="mx-auto mb-4 rounded-circle bg-success text-white d-flex justify-content-center align-items-center"
                                style={{
                                    width: "70px",
                                    height: "70px",
                                    fontSize: "24px",
                                    fontWeight: "bold"
                                }}
                            >

                                {step.number}

                            </div>

                            <h4 className="fw-bold">

                                {step.title}

                            </h4>

                            <p className="text-muted mt-3">

                                {step.description}

                            </p>

                        </div>

                    </div>

                ))}

            </div>

        </section>

    );

}

export default HowItWorks;