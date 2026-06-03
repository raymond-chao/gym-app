import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";

function Dashboard() {
    const [exercises, setExercises] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        api.get("/exercises")
            .then((response) => setExercises(response.data))
            .catch(() => navigate("/"));  // om token saknas/ogiltig → tillbaka till login
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        navigate("/");
    };

    return (
        <div>
            <h2>Mina övningar</h2>
            <button onClick={handleLogout}>Logga ut</button>
            <ul>
                {exercises.map((ex) => (
                    <li key={ex.id}>{ex.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default Dashboard;