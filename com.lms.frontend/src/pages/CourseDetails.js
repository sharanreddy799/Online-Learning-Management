import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const CourseDetails = () => {
  const { id } = useParams();
  const [course, setCourse] = useState(null);
  useEffect(() => {
    axios
      .get("/api/courses/${id}")
      .then((response) => {
        setCourse(response.data);
      })
      .catch((error) => {
        console.error("Error fetching courses");
      });
  }, [id]);

  if (!course) {
    return <div>Loaging...</div>;
  }
  return (
    <div>
      <h1>{course.title}</h1>
      <p>{course.description}</p>
      <p>{course.syllabus}</p>
      <p>Schedule: {course.schedule}</p>
    </div>
  );
};

export default CourseDetails;
