// @ts-check
import { defineConfig } from "astro/config"
import tailwindcss from "@tailwindcss/vite"

// https://astro.build/config
export default defineConfig({
    build: {
        format: "preserve",
    },
    vite: {
        plugins: [
            tailwindcss(),
        ],
        server: {
            proxy: {
                "/api": {
                    target: "https://www.flappygrant.com",
                    changeOrigin: true,
                },
            },
        },
    },
})
