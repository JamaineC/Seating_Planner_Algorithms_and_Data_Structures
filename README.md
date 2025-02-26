# Seating Plan System – Java & Algorithms  
## Project Overview  
This project is a **Algorithms and Data Structures** assignment from **Aberystwyth University**, focusing on **Java-based seating plan optimization**. The system assigns guests to tables using **ArrayLists, HashSets, and HashMaps** while enforcing **seating rules and constraints**. The solution incorporates **rule validation, backtracking for solving, and heuristic algorithms** like **simulated annealing**. The project also includes **time complexity analysis, testing, and self-evaluation**.  

## Prerequisites  
Java 17 or later, an IDE such as IntelliJ IDEA or Eclipse.  

## Installation & Setup  
Clone the repository: `git clone https://github.com/your-repo/seating-plan-java.git && cd seating-plan-java`  
Compile all Java files: `javac *.java`  
Run the program: `java Solver`  

## System Features  
The **Plan** class creates and manages seating arrangements, storing tables as **ArrayLists of HashSets** for fast access and modification. The **Rules** class enforces seating constraints by maintaining **friend and enemy relationships** in **HashMaps**. The **Solver** class implements **recursive backtracking** to find valid seat assignments while ensuring **all constraints are satisfied**. A **heuristic algorithm (simulated annealing)** is also explored for **alternative optimization techniques**.  

## Core Components  
The **Plan** class handles **table management, guest placement, and validation**. The **Rules** class defines **friendship and conflict rules**. The **Solver** class applies **backtracking algorithms** to generate valid seating arrangements, while **time complexity analysis** provides insight into performance.  

## Troubleshooting  
If the **program does not compile**, ensure **all Java files are present and correctly referenced**. If **seating constraints fail**, verify **isPlanOK logic in the Rules class**. If **backtracking is slow**, consider **optimizing recursive calls or implementing heuristics**.  

## Future Improvements  
Enhancements could include **graph-based seating visualization**, **faster constraint-solving using greedy algorithms**, and **expanding heuristic approaches like genetic algorithms**.  

## License  
This project is released for **educational and research purposes**. Contributions and improvements are welcome!  
