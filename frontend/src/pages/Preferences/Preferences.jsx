import { useState } from "react";

function Preferences() {

    const [formData, setFormData] = useState({
        dietType: "",
        goal: "",
        budget: "",
        region: "",
        allergies: "",
        dislikedFoods: "",
        mealsPerDay: "",
        spicyFood: false,
        seasonalFood: false,
        aiAutoUpdate: true
    });

    const handleChange = (e) => {

        const { name, value, type, checked } = e.target;

        setFormData({
            ...formData,
            [name]: type === "checkbox" ? checked : value
        });

    };

    const handleSubmit = (e) => {

        e.preventDefault();

        console.log(formData);

        alert("Preferences Saved");

    };

    return (

        <div className="container py-5">

            <div className="row justify-content-center">

                <div className="col-lg-8">

                    <div className="card shadow p-5 rounded-4">

                        <h2 className="text-center text-success fw-bold mb-4">
                            Meal Preferences
                        </h2>

                        <form onSubmit={handleSubmit}>

                            {/* Diet Type */}

                            <div className="mb-3">

                                <label className="form-label">
                                    Diet Type
                                </label>

                                <select
                                    className="form-select"
                                    name="dietType"
                                    value={formData.dietType}
                                    onChange={handleChange}
                                >

                                    <option value="">Select</option>
                                    <option>Vegetarian</option>
                                    <option>Non Vegetarian</option>
                                    <option>Vegan</option>
                                    <option>Jain</option>

                                </select>

                            </div>

                            {/* Goal */}

                            <div className="mb-3">

                                <label className="form-label">
                                    Goal
                                </label>

                                <select
                                    className="form-select"
                                    name="goal"
                                    value={formData.goal}
                                    onChange={handleChange}
                                >

                                    <option value="">Select</option>
                                    <option>Weight Loss</option>
                                    <option>Weight Gain</option>
                                    <option>Muscle Gain</option>
                                    <option>Maintain</option>

                                </select>

                            </div>

                            {/* Budget */}

                            <div className="mb-3">

                                <label className="form-label">
                                    Budget
                                </label>

                                <select
                                    className="form-select"
                                    name="budget"
                                    value={formData.budget}
                                    onChange={handleChange}
                                >

                                    <option value="">Select</option>
                                    <option>Low</option>
                                    <option>Medium</option>
                                    <option>High</option>

                                </select>

                            </div>

                            {/* Region */}

                            <div className="mb-3">

                                <label className="form-label">
                                    Region
                                </label>

                                <select
                                    className="form-select"
                                    name="region"
                                    value={formData.region}
                                    onChange={handleChange}
                                >

                                    <option value="">Select</option>
                                    <option>North India</option>
                                    <option>South India</option>
                                    <option>East India</option>
                                    <option>West India</option>

                                </select>

                            </div>

                            {/* Allergies */}

                            <div className="mb-3">

                                <label className="form-label">
                                    Allergies
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Milk, Peanut"
                                    name="allergies"
                                    value={formData.allergies}
                                    onChange={handleChange}
                                />

                            </div>

                            {/* Disliked Foods */}

                            <div className="mb-3">

                                <label className="form-label">
                                    Disliked Foods
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Brinjal, Mushroom"
                                    name="dislikedFoods"
                                    value={formData.dislikedFoods}
                                    onChange={handleChange}
                                />

                            </div>

                            {/* Meals Per Day */}

                            <div className="mb-4">

                                <label className="form-label">
                                    Meals Per Day
                                </label>

                                <select
                                    className="form-select"
                                    name="mealsPerDay"
                                    value={formData.mealsPerDay}
                                    onChange={handleChange}
                                >

                                    <option value="">Select</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>

                                </select>

                            </div>

                            {/* Checkboxes */}

                            <div className="form-check mb-2">

                                <input
                                    className="form-check-input"
                                    type="checkbox"
                                    name="spicyFood"
                                    checked={formData.spicyFood}
                                    onChange={handleChange}
                                />

                                <label className="form-check-label">
                                    Spicy Food
                                </label>

                            </div>

                            <div className="form-check mb-2">

                                <input
                                    className="form-check-input"
                                    type="checkbox"
                                    name="seasonalFood"
                                    checked={formData.seasonalFood}
                                    onChange={handleChange}
                                />

                                <label className="form-check-label">
                                    Seasonal Food
                                </label>

                            </div>

                            <div className="form-check mb-4">

                                <input
                                    className="form-check-input"
                                    type="checkbox"
                                    name="aiAutoUpdate"
                                    checked={formData.aiAutoUpdate}
                                    onChange={handleChange}
                                />

                                <label className="form-check-label">
                                    AI Auto Update
                                </label>

                            </div>

                            <button
                                type="submit"
                                className="btn btn-success w-100"
                            >

                                Save Preferences

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Preferences;