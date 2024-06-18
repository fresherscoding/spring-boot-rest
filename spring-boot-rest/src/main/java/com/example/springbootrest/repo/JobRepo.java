package com.example.springbootrest.repo;

import com.example.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);

}



//List<JobPost> jobs = new ArrayList<>();
//
//public JobRepo() {
//
//    // Java Developer Job Post
//    jobs.add(new JobPost (1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//
//    // Frontend Developer Job Post
//    jobs.add(
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//                    3, List.of("HTML", "CSS", "JavaScript", "React")));
//
//    // Data Scientist Job Post
//    jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//            List.of("Python", "Machine Learning", "Data Analysis")));
//
//    // Network Engineer Job Post
//    jobs.add(new JobPost(4, "Network Engineer",
//            "Design and implement computer networks for efficient data communication", 5,
//            List.of("Networking", "Cisco", "Routing", "Switching")));
//
//    // Mobile App Developer Job Post
//    jobs
//            .add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
//                    3, List.of("iOS Development", "Android Development", "Mobile App")));
//
//    // DevOps Engineer Job Post
//    jobs.add(
//            new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
//                    4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));
//
//}
//
//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(JobPost jobPost){
//    jobs.add(jobPost);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId) {
//    for (JobPost jobPost : jobs){
//        if (jobPost.getPostId() == postId)
//            return jobPost;
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for (JobPost job : jobs){
//        if (job.getPostId() == jobPost.getPostId()){
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setReqExperience(jobPost.getReqExperience());
//            job.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    for (JobPost jobPost : jobs){
//        if (jobPost.getPostId() == postId){
//            jobs.remove(jobPost);
//        }
//    }
//}