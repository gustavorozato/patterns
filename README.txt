In order to run this project you will have to add
MAILTRAP_USERNAME and MAILTRAP_PASSWORD in your environment
variables

If you want to run it with docker, don't forget to
inject it while building the image with

docker build . --build-arg mailtrap_username=${MAILTRAP_USERNAME} --build-arg mailtrap_password=${MAILTRAP_PASSWORD}