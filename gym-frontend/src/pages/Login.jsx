import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const response = await api.post("/auth/login", { username, password });
            localStorage.setItem("token", response.data);
            navigate("/dashboard");
        } catch (err) {
            setError("Fel användarnamn eller lösenord");
        }
    };

    return (
        <div>
            <h2>Logga in</h2>
            <input
                type="text"
                placeholder="Användarnamn"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />
            <input
                type="password"
                placeholder="Lösenord"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <button onClick={handleLogin}>Logga in</button>
            {error && <p style={{ color: "red" }}>{error}</p>}
        </div>
    );
}

export default Login;