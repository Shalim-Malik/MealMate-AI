import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import { login } from "../../services/authService";

function Login() {
const navigate = useNavigate();

const [formData, setFormData] = useState({
    email: "",
    password: ""
});

const handleChange = (e) => {
    setFormData({
        ...formData,
        [e.target.name]: e.target.value
    });
};

const handleSubmit = async (e) => {


    e.preventDefault();

    try {

        const response = await login(formData);

       localStorage.setItem("token", response.token);

        alert("Login Successful");

        navigate("/dashboard");

    } catch (error) {

        alert(
            error.response?.data?.message || "Login Failed"
        );

    }

};
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


                               <form onSubmit={handleSubmit}>

                                   <div className="mb-3">

                                       <label className="form-label">
                                           Email
                                       </label>

                                       <input
                                           type="email"
                                           className="form-control"
                                           name="email"
                                           value={formData.email}
                                           onChange={handleChange}
                                           required
                                       />

                                   </div>

                                   <div className="mb-4">

                                       <label className="form-label">
                                           Password
                                       </label>

                                       <input
                                           type="password"
                                           className="form-control"
                                           name="password"
                                           value={formData.password}
                                           onChange={handleChange}
                                           required
                                       />

                                   </div>

                                   <button
                                       type="submit"
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

export default Login