import { BrowserRouter, Routes, Route } from "react-router-dom";

import Landing from "../pages/Landing/Landing";
import Login from "../pages/Login/Login";
import Signup from "../pages/Signup/Signup";
import Dashboard from "../pages/Dashboard/Dashboard";
import ProtectedRoute from "./ProtectedRoute";
import MainLayout from "../layouts/MainLayout";

function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>

                <Route
                    path="/"
                    element={
                        <MainLayout>
                            <Landing />
                        </MainLayout>
                    }
                />

                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>

                            <MainLayout>
                                <Dashboard />
                            </MainLayout>

                        </ProtectedRoute>
                    }
                />

                <Route path="/login" element={<Login />} />

                <Route path="/signup" element={<Signup />} />

            </Routes>
        </BrowserRouter>
    );
}

export default AppRoutes;