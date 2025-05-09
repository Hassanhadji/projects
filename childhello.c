//Hassan Hadji-Ibrahim 300126629
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define BUFFER_SIZE 25

int main() {
    char write_msg[BUFFER_SIZE];
    char read_msg[BUFFER_SIZE];
    int pipe1[2], pipe2[2];
    pid_t pid;

    if (pipe(pipe1) == -1 || pipe(pipe2) == -1) {
        fprintf(stderr, "Pipe failed");
        return 1;
    }

    pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed");
        return 1;
    }

    if (pid > 0) { // Parent process
        close(pipe1[0]); // Close reading end of pipe1
        close(pipe2[1]); // Close writing end of pipe2

        strcpy(write_msg, "Greetings son");
        write(pipe1[1], write_msg, strlen(write_msg) + 1);
        sleep(2);

        read(pipe2[0], read_msg, BUFFER_SIZE);
        printf("%s\n", read_msg);
        sleep(2);

        strcpy(write_msg, "How are you son");
        write(pipe1[1], write_msg, strlen(write_msg) + 1);
        sleep(2);

        read(pipe2[0], read_msg, BUFFER_SIZE);
        printf("%s\n", read_msg);
        sleep(2);

        close(pipe1[1]);
        close(pipe2[0]);
        wait(NULL);
    } else { // Child process
        close(pipe1[1]); // Close writing end of pipe1
        close(pipe2[0]); // Close reading end of pipe2

        read(pipe1[0], read_msg, BUFFER_SIZE);
        printf("%s\n", read_msg);
        sleep(2);

        strcpy(write_msg, "Hello dad");
        write(pipe2[1], write_msg, strlen(write_msg) + 1);
        sleep(2);

        read(pipe1[0], read_msg, BUFFER_SIZE);
        printf("%s\n", read_msg);
        sleep(2);

        strcpy(write_msg, "Fine dad thanks");
        write(pipe2[1], write_msg, strlen(write_msg) + 1);
        sleep(2);

        close(pipe1[0]);
        close(pipe2[1]);
    }

    return 0;
}