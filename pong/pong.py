import turtle
import winsound

window = turtle.Screen()
window.title("Pong")
window.bgcolor("black")
window.setup(width = 800, height = 600)
window.tracer(0)


#racket 1
racket_1 = turtle.Turtle()
racket_1.speed(0)
racket_1.shape("square")
racket_1.color("white")
racket_1.shapesize(stretch_wid = 5, stretch_len = 1)
racket_1.penup()
racket_1.goto(-350, 0)


#racket 2
racket_2 = turtle.Turtle()
racket_2.speed(0)
racket_2.shape("square")
racket_2.color("white")
racket_2.shapesize(stretch_wid = 5, stretch_len = 1)
racket_2.penup()
racket_2.goto(350, 0)

#ball
ball1 = turtle.Turtle()
ball1.speed(0)
ball1.shape("square")
ball1.color("white")
ball1.penup()
ball1.goto(0, 0)

ball1.dx = 0.25
ball1.dy = 0.25

#methods
def racket_1_up():
    y = racket_1.ycor()
    y += 20
    racket_1.sety(y)

def racket_1_down():
    y = racket_1.ycor()
    y -= 20
    racket_1.sety(y)

def racket_2_up():
    y = racket_2.ycor()
    y += 20
    racket_2.sety(y)

def racket_2_down():
    y = racket_2.ycor()
    y -= 20
    racket_2.sety(y)

#key binds
window.listen()
window.onkeypress(racket_1_up, "w")
window.onkeypress(racket_1_down, "s")
window.onkeypress(racket_2_up, "Up")
window.onkeypress(racket_2_down, "Down")


#Pen
pen = turtle.Turtle()
pen.speed(0)
pen.color("white")
pen.penup()
pen.hideturtle()
pen.goto(0, 260)
pen.write("player 1: 0  player 2: 0", align = "center", font = ("Courier", 24, "normal"))

#score
score_1 = 0
score_2 = 0


#main loop
while True:
    window.update()


    #movement
    ball1.setx(ball1.xcor() + ball1.dx)
    ball1.sety(ball1.ycor() + ball1.dy)

    #boundaries
    if ball1.ycor() > 290:
        ball1.sety(290)
        ball1.dy *= -1 
        winsound.PlaySound("boin.mp3", winsound.SND_ASYNC)

    if ball1.ycor() < -290:
        ball1.sety(-290)
        ball1.dy *= -1
        winsound.PlaySound("boin.mp3", winsound.SND_ASYNC)

    if ball1.xcor() > 390:
        ball1.goto(0, 0)
        ball1.dx *= -1
        score_1 += 1
        pen.clear()
        pen.write("player 1: {}  player 2: {}".format(score_1, score_2), align = "center", font = ("Courier", 24, "normal"))

    if ball1.xcor() < -390:
        ball1.goto(0, 0)
        ball1.dx *= -1
        score_2 += 1
        pen.clear()
        pen.write("player 1: {}  player 2: {}".format(score_1, score_2), align = "center", font = ("Courier", 24, "normal"))

    #collisions
    if (ball1.xcor() > 340 and ball1.xcor() < 350) and (ball1.ycor() < racket_2.ycor() + 40 and ball1.ycor() > racket_2.ycor() -40 ):
        ball1.setx(340)
        ball1.dx *= -1
        winsound.PlaySound("boin.mp3", winsound.SND_ASYNC)

    if (ball1.xcor() < -340 and ball1.xcor() > -350) and (ball1.ycor() < racket_1.ycor() + 40 and ball1.ycor() > racket_1.ycor() -40 ):
        ball1.setx(-340)
        ball1.dx *= -1
        winsound.PlaySound("boin.mp3", winsound.SND_ASYNC)