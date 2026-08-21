import { useState } from "react";
import { register } from "../api/client";


function Register() {

const[username, setUsername] = useState("");
const[password, setPassword] = useState("");

async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    await register({ username, password });
}
   

    return (
    <form onSubmit={handleSubmit}>
        <input 
            type="text"
            value = {username}
            onChange={(e) => setUsername(e.target.value)}
        />
        <input 
            type="password"
            value = {password}
            onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Register</button>
    </form>
);
}


export default Register; 



