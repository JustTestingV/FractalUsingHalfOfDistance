# Fractals Using Half Of Distance

It's programm realization of math "trick" - you can make fractals, by placing dot in the middle of the distance betweet current dot and next random top of basic fugure.

*For example:*

You guessed a triangle. 
First, placing top-dots of this tringle.

file.![2021-08-12 (3)](https://user-images.githubusercontent.com/64104994/129270745-d63f70ea-195e-46da-af75-e585357e1b69.png)

Then, choosing random top, for example up-top.

![2021-08-12 (4)](https://user-images.githubusercontent.com/64104994/129270844-97802c34-1f27-4458-b399-fe0d6f76c2ba.png)

Choosing next random top (here it's left).

![2021-08-12 (5)](https://user-images.githubusercontent.com/64104994/129270979-92156914-2025-41f9-a0f1-c010b7d6b73f.png)

Then placing dot in the middle of space between this 2 tops.

![2021-08-13](https://user-images.githubusercontent.com/64104994/129271238-274fe14a-43ee-4f80-94ca-646e52ec57a4.png)

Then choosing another top, and placing dot between last dot and new top.

![2021-08-13](https://user-images.githubusercontent.com/64104994/129271300-0358a6de-09c0-4ee3-b0c7-503066235df8.png)

And continue doing this. At the end we're getting this:

![2021-08-12 (2)](https://user-images.githubusercontent.com/64104994/129271278-e655dad7-c338-455c-888f-11fbee4d483f.png)

## How to use application?
It's pretty simple. You need to download/clone project and open it with your IDE (project using scala, so if you don't have compiler for it, you need to download it too. It's very simple to do with IntelliJ IDEA).
Then you need to run file "App.scala"

This application has triangle, rectangle. Also you can see desired figure by entering count of sides of this shape.

![2021-08-13 (2)](https://user-images.githubusercontent.com/64104994/129271385-549966df-e87d-4841-90c4-2d6f6a43bd15.png)

Also, if you want, you can change number of dots an number of  application window pixels. You can do this by changing **`src/main/resources/application.conf`** 
