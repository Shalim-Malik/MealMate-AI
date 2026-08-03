

import { useState } from "react";
import { signup } from "../../services/authService";
function Signup() {
    const [formData, setFormData] = useState({
        fullName: "",
        email: "",
        password: "",
        confirmPassword: "",
        phoneNumber: ""
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

            await signup(formData);

            alert("Signup Successful");

            setFormData({
                fullName: "",
                email: "",
                password: "",
                confirmPassword: "",
                phoneNumber: ""
            });

        } catch (error) {

            alert(
                error.response?.data?.message || "Signup Failed"
            );

        }

    };

    return (

        <div className="container py-5">

            <div className="row justify-content-center">

                <div className="col-lg-5 col-md-7">

                    <div
                        className="card border-0 p-2"
                        style={{
                            borderRadius: "30px"
                        }}
                    >

                        <div className="card-body p-4 p-lg-5">

                            <h2 className="text-center fw-bold text-success">

                                🍃 MealMate AI

                            </h2>

                            <h4 className="text-center mb-4">

                                Create Your Account

                            </h4>

                           <form onSubmit={handleSubmit}>

                                <div className="mb-3">

                                    <label className="form-label">

                                        Full Name

                                    </label>

                                 <input
                                     type="text"
                                     name="fullName"
                                     value={formData.fullName}
                                     onChange={handleChange}
                                     className="form-control"
                                 />

                                </div>

                                <div className="mb-3">

                                    <label className="form-label">

                                        Email

                                    </label>

                                   <input
                                       type="email"
                                       name="email"
                                       value={formData.email}
                                       onChange={handleChange}
                                       className="form-control"
                                   />

                                </div>

                                <div className="mb-3">

                                    <label className="form-label">

                                        Password

                                    </label>

                                   <input
                                       type="password"
                                       name="password"
                                       value={formData.password}
                                       onChange={handleChange}
                                       className="form-control"
                                   />

                                </div>

                                <div className="mb-3">

                                    <label className="form-label">

                                        Confirm Password

                                    </label>

                                  <input
                                      type="password"
                                      name="confirmPassword"
                                      value={formData.confirmPassword}
                                      onChange={handleChange}
                                      className="form-control"
                                  />

                                </div>

                                <div className="mb-4">

                                    <label className="form-label">

                                        Phone Number

                                    </label>

                                  <input
                                      type="text"
                                      name="phoneNumber"
                                      value={formData.phoneNumber}
                                      onChange={handleChange}
                                     className="form-control rounded-pill py-3 px-4"
                                  />

                                </div>

                                <button
                                    type="submit"
                                    className="btn btn-success w-100 rounded-pill py-3 fw-semibold"
                                >

                                    Create Account

                                </button>

                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Signup;