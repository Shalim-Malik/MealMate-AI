import LogoutButton from "../../components/LogoutButton";
import { useNavigate } from "react-router-dom";

function Dashboard() {
const navigate = useNavigate();
    return (

        <div className="container py-5">

            <div className="d-flex justify-content-between align-items-center mb-5">

                <div>

                    <h1 className="fw-bold">

                        👋 Welcome to MealMate AI

                    </h1>

                    <p className="text-muted">

                        Your personalized AI nutrition dashboard.

                    </p>

                </div>

                <LogoutButton />

            </div>

            <div className="row g-4">

                <div className="col-md-6">

                    <div className="card shadow-sm p-4 rounded-4">

                        <h4>🍳 Today's Meal</h4>

                        <hr />

                        <p>Breakfast : --</p>

                        <p>Lunch : --</p>

                        <p>Dinner : --</p>

                    </div>

                </div>

                <div className="col-md-6">

                    <div className="card shadow-sm p-4 rounded-4">

                        <h4>🤖 AI Recommendation</h4>

                        <hr />

                        <p>

                            Your AI meal recommendation will appear here.

                        </p>

                    </div>

                </div>
                <div className="col-md-12">

                    <div className="card shadow-sm p-4 rounded-4">

                        <div className="d-flex justify-content-between align-items-center">

                            <div>

                                <h4>⚙ Complete Your Preferences</h4>

                                <p className="text-muted mb-0">
                                    Improve AI meal recommendations by completing your profile.
                                </p>

                            </div>

                            <button
                                className="btn btn-success"
                                onClick={() => navigate("/preferences")}
                            >
                                Complete Profile
                            </button>

                        </div>

                    </div>

                </div>

                <div className="col-md-6">

                    <div className="card shadow-sm p-4 rounded-4">

                        <h4>🛒 Grocery List</h4>

                        <hr />

                        <p>No grocery list available.</p>

                    </div>

                </div>

                <div className="col-md-6">

                    <div className="card shadow-sm p-4 rounded-4">

                        <h4>📅 Weekly Planner</h4>

                        <hr />

                        <p>Your weekly meal plan will appear here.</p>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Dashboard;