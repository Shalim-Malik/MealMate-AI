import { useNavigate } from "react-router-dom";

function LogoutButton() {

    const navigate = useNavigate();

    const handleLogout = () => {

        localStorage.removeItem("token");

        alert("Logged Out Successfully");

        navigate("/login");

    };

    return (

        <button
            className="btn btn-danger"
            onClick={handleLogout}
        >
            Logout
        </button>

    );

}

export default LogoutButton;