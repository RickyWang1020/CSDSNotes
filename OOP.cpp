// defining a class
#include <iostream>
#define LOG(x) std::cout << x << std::endl

class Player{
// set the visibility of the variables in this class
// by default, a class is set as private
// IMPORTANT: The only technical difference between "struct" and "class" is that:
// struct is by default public; while class is by default private
public:
    int x, y;
    int speed;
};

// define a class function outside the class
void Move(Player& player, int xa, int ya){
    player.x += player.speed * xa;
    player.y += player.speed * ya;
}

int main(){
    Player player;
    // calling the function that is outside the class
    Move(player, 1, -1);
    return 0;
}

// an alternate way of defining class functions (methods)
#include <iostream>
#define LOG(x) std::cout << x << std::endl

class Player{
public:
    int x, y;
    int speed;
    // define a class method
    void Move(int xa, int ya){
        x += speed * xa;
        y += speed * ya;
    }
};

int main(){
    Player player;
    // calling the function that is outside the class
    player.Move(1, -1);
    return 0;
}

// making struct by default private (same as class)
#include <iostream>
#define LOG(x) std::cout << x << std::endl
// replace all about struct with class
#define struct class

struct Player{
    int x, y;
    int speed;

    void Move(int xa, int ya){
        x += speed * xa;
        y += speed * ya;
    }
};

int main(){
    Player player;
    // this will cause an error because "struct" is now by default private
    player.Move(1, -1);
    return 0;
}

// static vs extern (by default it is extern)
#include <iostream>
void test(){
    // create variable a, and it will be deleted after test() is over
    // next time calling test() will create a new variable a
    int a = 0;
    a++;
    printf("a: %d\n", a);
    // create a variable b when test() is called for the first time
    // next time calling test(), will use the existing b instead of creating a new one
    // all the test() functions share the variable b
    // only when the program is over, variable b will be deleted
    static int b = 0;
    b++;
    printf("b: %d\n", b);
}

int main(){
    test();
    test();
    test();
    return 0;
}

// static variables: only one shared tunnel
#include <iostream>

struct Entity{
    // making two variables x and y static
    // we have only one tunnel pointing to x and one tunnel pointing to y separately
    // there is no longer class instances in static
    // static variables only have one tunnel (can only cover on the previous variable's value)
    static int x, y;

    void print(){
        std::cout << x << ", " << y << std::endl;
    }
};

// declare the existence of the static variables inside the Entity struct...
int Entity::x, Entity::y;

int main(){
    Entity e;
    // same as:
    // Entity::x = 2;
    // Entity::y = 14;
    e.x = 2;
    e.y = 14;

    Entity e1;
    // same as:
    // Entity::x = 34;
    // Entity::y = 22;
    e1.x = 34;
    e1.y = 22;

    // two print functions will have same outputs: 34, 22 (because there is only one tunnel!)
    e.print();
    e1.print();
    std::cin.get();
    return 0;
}

// static function cannot access external variables!
#include <iostream>

struct Entity{
    int x, y;
};

static void print(Entity e){
    std::cout << e.x << ", " << e.y << std::endl;
}

int main(){
    Entity e;
    e.x = 2;
    e.y = 14;

    Entity e1;
    e1.x = 34;
    e1.y = 22;

    print(e);
    print(e1);
    std::cin.get();
    return 0;
}

