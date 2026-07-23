export enum PopupType {
    INFO,
    WARNING,
    ERROR,
}

export function popup(type: PopupType, message: string) {
    switch (type) {
        case PopupType.INFO:
            console.log(message)
            break
        case PopupType.WARNING:
            console.warn(message)
            break
        case PopupType.ERROR:
            console.error(message)
            break
    }

    const popups = document.querySelector("div#popups")
    if (popups != null) {
        const popup = document.createElement("div")
        popup.classList.add("card", "max-w-70")

        switch (type) {
            case PopupType.WARNING:
                popup.style.backgroundColor = "#f80";
                break
            case PopupType.ERROR:
                popup.style.backgroundColor = "#f00";
                break
        }

        popup.textContent = message
        popups.appendChild(popup)
    } else {
        console.log(popups)
    }
}
