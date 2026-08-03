function FeaturesSection() {

    const features = [
        {
            icon: "🤖",
            title: "AI Meal Planning",
            description: "Generate personalized meal plans according to your health goals."
        },
        {
            icon: "🥗",
            title: "Nutrition Tracking",
            description: "Track calories, protein, carbs and fats with every meal."
        },
        {
            icon: "🛒",
            title: "Smart Grocery List",
            description: "Automatically generate grocery lists from your meal plans."
        },
        {
            icon: "📅",
            title: "Weekly Planner",
            description: "Plan your meals for the entire week with one click."
        }
    ];

    return (

       <section
           id="features"
           className="py-5"
           style={{ background: "#F6FFF7" }}
       >

            <div className="container">

                <div className="text-center mb-5">

                    <h2 className="fw-bold display-5">
                        Why Choose
                        <span className="text-success"> MealMate AI?</span>
                    </h2>

                    <p className="text-muted fs-5">
                        Everything you need for healthy eating.
                    </p>

                </div>

                <div className="row g-4">

                    {features.map((feature, index) => (

                        <div
                            className="col-md-6 col-lg-3"
                            key={index}
                        >

                            <div className="card border-0 shadow rounded-4 h-100 p-3">

                                <div className="card-body text-center">

                                    <h1 className="display-4">
                                        {feature.icon}
                                    </h1>

                                    <h4 className="fw-bold mt-3">
                                        {feature.title}
                                    </h4>

                                    <p className="text-muted mt-3">
                                        {feature.description}
                                    </p>

                                </div>

                            </div>

                        </div>

                    ))}

                </div>

            </div>

        </section>

    );

}

export default FeaturesSection;