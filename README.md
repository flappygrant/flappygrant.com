<div align="center">
    <h1>
        <a href="https://www.flappygrant.com">
            <small>www.</small>FlappyGrant<small>.com</small>
        </a>
    </h1>
</div>

**The FlappyGrant website** hosts minigames inside your browser, instantly playable by a single click! It also provides links to other products/services, and contains many resources you might find interesting.

## Monorepo structure

| Name     | Directory              | Description                               |
|----------|------------------------|-------------------------------------------|
| Frontend | [/frontend](frontend/) | Frontend website source                   |
| Backcore | [/backcore](backcore/) | Main backend [PghServer](#hosting) plugin |

## Hosting

We use a non-standard HTTP implementation named **PghServer** (Production-Grade HTTP Server), available [here](https://github.com/pghserver/pghserver.git) as a GitHub repository. But what is **PghServer**? In short, it allows our team to implement different routes and features as their own contained plugins/expansions of sorts. One plugin we use is [PghStatic](https://github.com/pghserver/pghstatic.git), a plugin officially maintained by **PghServer** to serve files as routes!

And for our hosting service, we choose the most stable of a few options supporting [Java](https://java.com), which **PghServer** runs on. While it's a bad idea to state the exact host, you should know we use **Cloudflare** for security and proxy purposes. They have a long history of enforcing proper security down to the smallest of attacks, which certainaly helps!

## Licensing

Due to the scale of this project, we have a custom and much stricter license to ensure educational purposes are required for the majority of what other licenses allow.

You can view it [here](LICENSE)!
