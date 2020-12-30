[ICPC NERC Huawei Challenge — Cloud Scheduling Challenge](https://codeforces.com/blog/entry/85241)
====

This contest is based on some real problems from Huawei Cloud team. The task is simplified, but still very challenging. You need to find a schedule for a variety of realistic problem instances, where the goal will be minimizing two different cost functions. There is a non-trivial tradeoff, decision you have to make, on how to choose what is best for a particular case. You will be provided with examples that can help you to tackle the problem. A good solution may also require diving deeper into the nature of the problem, and creating some dataset of your own. We believe there are multiple approaches one can try here, and some crossover of the algorithms will also increase your chances to win. Good luck, we hope this will be fun!

In this video Andrey Tikhonov, the co-author of Cloud Scheduling Challenge will explain the basics of the task and describe some special cases and examples: https://youtu.be/29_RwCFtHFw 

---

## [A. Fixing the Cloud](https://codeforces.com/contest/1460/problem/A)

https://codeforces.com/contest/1460/problem/A



### The most optimized solutions for this problem could be found here:
1. [hermenier et al. - entropy: a Consolidation manager for clusters](https://hal.archives-ouvertes.fr/hal-01102354/document)
2. [bari et. al. - CQNCR: optimal VM migration planning in cloud data centers](https://www.researchgate.net/publication/269294303_CQNCR_Optimal_VM_migration_planning_in_cloud_data_centers/link/580582e108aee314f68e2591/download)


/** 𝑆𝑐𝑜𝑟𝑒=1000⋅log10(𝑇𝑜𝑡𝑎𝑙_𝑠𝑡𝑒𝑝𝑠×𝑀𝑒𝑚𝑜𝑟𝑦_𝑚𝑜𝑣𝑒𝑑_𝑖𝑛_𝐺𝐵+1) */ 

#### SImple baseline - reduce from n to n-1

```
1. n:= number of servers, not equal to their optimal configration;
2. while n!=0:
    3. Choose any server out of n;
    4. Move out all VMs, that do not belong to be at this server:
        5. Move VMs to their optimal place, if possible, or some host from n
    5. Move in all VMs, that must be here, but are not;
    6. n:=-1;
    7. GOTO 2;
```
* this basic algorithm ~234 000 score (30 tests)
* Improvements - include in a step parallel fixing of several hosts, avoid conflicts; Sort servers and VMs at each step.

----

#### Greedy algorithm with cycle resolving if deadlock
```
1. m:= misplaced VMs;
2. While m != 0:
    3. k:= size of a subset in m VMs, that can be included in this step;
    4. Move all k VMs to their optimal place;
    5. If k = 0 - resolve deadlock: 
        6. Find simple cycle of the smallest size in the graph;
        7. Move largest (in GB) VM from this cycle to a temporary server;
        8. Move all VMs from the cycle to optimal place;
        9. Move VM from 7. to the optimal place
    6. m:= m-k
    7. GOTO 2
```
* This algorithm ~180 000 score (30 tests)
* Hermenier et al. - Entropy: a Consolidation Manager for Clusters (2009)

---

#### List of techniques used by contestants
1. Greedy with deadlock resolving
2. Using many comparators when choosing server, VM
3. PageRank, weighted PageRank
4. Random search with backtracking
5. Perfect matching
6. Min-cost max-flow (Edmonds-Karp, Dinic)
7. Metaheuristics (genetic)
8. Simulated annealing
9. Topological sorting
10. Maximal independent subset
11. ...
