import { manifestOf } from "./manifest"
import { popup, PopupType } from "./popup"

const query = new URLSearchParams(window.location.search)
let gameId = query.get("g") ?? ""
if (gameId.trim() == "") window.location.replace("/index.html")

document.addEventListener("DOMContentLoaded", () => {
    const gameContainer = document.querySelector("div#game-container")
    if (gameContainer) {
        async function applyJavaScript() {
            try {
                const manifest = await manifestOf(gameId)
                if (typeof manifest == "string") throw new Error("Failed to retrieve game data!")

                const response = await fetch(manifest.source)
                if (!response.ok) throw new Error("Game source likely does not exist!")

                const script = document.createElement("script")
                script.textContent = await response.text()
                gameContainer!.appendChild(script)
            } catch (ex) {
                popup(PopupType.ERROR, (ex as Error).message)
            }
        }

        applyJavaScript()
    }

    const gameOptions = document.querySelector("div#game-options")
    if (gameOptions) {
        function appendOption(name: string, onClick: (button: HTMLButtonElement) => void) {
            const button = document.createElement("button")
            button.classList.add("py-2", "px-4", "bg-blur-md", "bg-back-accent/50", "rounded-md", "shadow", "hover:bg-back-accent", "active:bg-red-500")
            button.textContent = name
            button.addEventListener("click", () => onClick(button))
            gameOptions!.appendChild(button)
        }

        appendOption("Share", async button => {
            try {
                await navigator.clipboard.writeText(`https://play.flappygrant.com/${gameId}`)
                button.textContent = "Copied link!"
            } catch {
                button.textContent = "Failed!"
            }

            setTimeout(() => button.textContent = "Share", 1000)
        })
    }
})
