# ☠️ Quarkus Crash Demo

This repository contains intentionally crash-prone **Quarkus-based Java applications** designed to simulate real-world failure scenarios in Kubernetes environments.

Each sub-project demonstrates a different class of failure, making it useful for:

- Resilience testing
- Observability tooling demos
- OOM crash reproduction
- JVM tuning workshops

---

## 📂 Crash Scenarios Included

| Crash Type               | Description |
|--------------------------|-------------|
| 🔥 **Heap OOM**          | Continuously allocates memory until the JVM heap overflows. |
| 💀 **System OOM**        | Uses more memory than the container limit, leading to container kill by the OS. |
| 🧠 **Non-Heap OOM**      | Triggers metaspace exhaustion by dynamically loading classes. |
| 🧵 **Thread Exhaustion** | Spawns unbounded threads, exhausting system or JVM thread limits. |
| 📁 **FD Leak (Bonus)**   | Opens file descriptors/sockets without closing, leading to resource exhaustion. |

---

## 🚀 Running the Demos

Each crash type is packaged as a separate Quarkus project:
```bash
quarkus-crash/
├── heap-oom/
├── system-oom/
├── nonheap-oom/
├── thread-exhaustion/
└── fd-leak/
```


### 🐳 Docker Build

Each project contains a multi-stage `Dockerfile`:
```bash
cd heap-oom
docker build -t <repo>/<image>:<tag> .
```

### ☸️ Kubernetes Deployment

Each crash demo has its own Kubernetes deployment YAML:
```bash
kubectl apply -f heap-oom/k8s-deployment.yaml
```

You can adjust resource limits and JVM settings via the manifest to control crash timing.

### ⚠️ Disclaimer
This project is designed to cause failures — please do not deploy these to production clusters.





















