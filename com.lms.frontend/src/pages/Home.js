import React from "react";
import CourseList from "../components/CourseList";

const Home = () => {
  return (
    <div>
      <h1>
        Welcome to the Online Learning Management System{" "}
        {console.log("This is homepage header")}
      </h1>
      <CourseList />
    </div>
  );
};

export default Home;
