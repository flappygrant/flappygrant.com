export type GameManifest = {
    title: string
    description: string
    source: string
}

export async function manifestOf(gameId: string): Promise<GameManifest | string> {
    try {
        const response = await fetch(`https://api.flappygrant.com/${gameId}.json`)
        if (!response.ok) throw new Error(`Status returned not okay, specifically code ${response.status}`)

        const data = await response.json()
        return data as GameManifest
    } catch (ex) {
        return `Could not retrieve manifest of ${gameId}! ${(ex as Error).message}`
    }
}
