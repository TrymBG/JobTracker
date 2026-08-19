const BASE_URL = "http://localhost:8080";

interface RegisterRequest {
    username: string;
    password: string;
}

interface LoginRequest {
    username: string;
    password: string;
}

interface LoginResponse {
    token: string;
}

export async function register(data: RegisterRequest): Promise<void> {
    const response = await fetch(`${BASE_URL}/api/auth/register`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error("Failed to register");
    }
}

export async function login(data: LoginRequest): Promise<LoginResponse> {
    const response = await fetch(`${BASE_URL}/api/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error("Failed to login");
    }

    const loginResponse: LoginResponse = await response.json();
    return loginResponse;
}
