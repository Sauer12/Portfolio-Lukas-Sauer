//package sk.tuke.gamestudio;
//
//import sk.tuke.gamestudio.entity.Student;
//import sk.tuke.gamestudio.entity.StudyGroup;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Transactional
//public class PlaygroundJPA {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//    public void play(){
//        System.out.println("Opening PlaygroundJPA");

//        entityManager.persist(new StudyGroup("basic"));
//        entityManager.persist(new StudyGroup("advanced"));
//        entityManager.persist(new StudyGroup("expert"));

//        List<StudyGroup> studyGroups =
//                entityManager.createQuery("select g from StudyGroup g")
//                                .getResultList();
//
//        int noOfGroups = studyGroups.size();
//        for(int groupNo = 0; groupNo < noOfGroups; groupNo++){
//            System.out.println(studyGroups.get(groupNo));
//        }
//
//        Student student = new Student("Anna", "Novotna", studyGroups.get(2));
//
//        System.out.println(student);
//
//        entityManager.persist(student);
//
//        System.out.println("Closing PlaygroundJPA");
//    }
//}

//public class PlaygroundJPA {
//
//    @Autowired
//    private RatingService ratingService;
//
//    public void play(){
//        System.out.println("Opening PlaygroundJPA");
//
//        Rating rating = new Rating("mines", "MMM", 4, new Date());
//        Rating rating2 = new Rating("mines", "Palo", 5, new Date());
//        ratingService.setRating(rating);
//
//        rating.setUsername("Palo");
//        rating.setRating(1);
//
//        ratingService.setRating(rating);
//
//        System.out.printf("rating = %d", ratingService.getRating("mines", "MMM"));
//        System.out.printf("rating = %d", ratingService.getRating("mines", "KarolkoPetrovic"));
//
//        System.out.println("Closing PlaygroundJPA");
//    }
//}
