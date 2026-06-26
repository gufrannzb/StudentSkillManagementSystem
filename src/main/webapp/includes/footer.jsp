<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<footer>
    
    <div class="footer-section about">
        
    </div>
    
    <br>

    <div class="footer-section links">
        <h3>Quick Links</h3>
        <ul>
            <li>
    <a href="<%=request.getContextPath()%>/student/login.jsp">
        <i class="fas fa-chevron-right"></i> Log In
    </a>
</li>

<li>
    <a href="<%=request.getContextPath()%>/SkillServlet">
        <i class="fas fa-chevron-right"></i> Explore Skills
    </a>
</li>

<li>
    <a href="<%=request.getContextPath()%>/student/privacy.jsp">
        <i class="fas fa-chevron-right"></i> Privacy Policy
    </a>
</li>
        </ul>
    </div>
    <br>

    <div class="footer-section team">
        <h3>Developed By</h3>
        <ul>
            <li class="team-member">
                <p>Mohd Gufran</p>
                <div class="member-socials">
                    <a href="https://instagram.com/gufrannzb" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a>
                    <a href="https://facebook.com/gufrannzb" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://x.com/gufrannzb" target="_blank" title="Twitter/X"><i class="fab fa-x-twitter"></i></a>
                    <a href="mailto:mohd_gufranbca2023@msit.edu.in"><i class="fas fa-envelope"></i></a>
                </div>
            </li>
            
            <li class="team-member">
                <p>Munazeer Siddiquie</p>
                <div class="member-socials">
                    <a href="https://instagram.com/rahul_insta" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a>
                    <a href="https://facebook.com/rahul_fb" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://x.com/rahul_x" target="_blank" title="Twitter/X"><i class="fab fa-x-twitter"></i></a>
                    <a href="mailto:rahul@gmail.com" title="Gmail"><i class="fas fa-envelope"></i></a>
                </div>
            </li>

            <li class="team-member">
                <p>Anjali Kumari</p>
                <div class="member-socials">
                    <a href="https://instagram.com/sameer_insta" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a>
                    <a href="https://facebook.com/sameer_fb" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://x.com/sameer_x" target="_blank" title="Twitter/X"><i class="fab fa-x-twitter"></i></a>
                    <a href="mailto:sameer@gmail.com" title="Gmail"><i class="fas fa-envelope"></i></a>
                </div>
            </li>

            <li class="team-member">
                <p>Tushar Mahato</p>
                <div class="member-socials">
                    <a href="https://instagram.com/priya_insta" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a>
                    <a href="https://facebook.com/priya_fb" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://x.com/priya_x" target="_blank" title="Twitter/X"><i class="fab fa-x-twitter"></i></a>
                    <a href="mailto:priya@gmail.com" title="Gmail"><i class="fas fa-envelope"></i></a>
                </div>
            </li>

            <li class="team-member">
                <p>Ashish Sharma</p>
                <div class="member-socials">
                    <a href="https://instagram.com/gufrannzb" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a>
                    <a href="https://facebook.com/gufran" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://x.com/amit_x" target="_blank" title="Twitter/X"><i class="fab fa-x-twitter"></i></a>
                    <a href="mailto:amit@gmail.com" title="Gmail"><i class="fas fa-envelope"></i></a>
                </div>
            </li>
        </ul>
    </div>
    
    <br>

    <div class="footer-section contact">
        <h3>Contact Us</h3>
        <p><i class="fas fa-map-marker-alt"></i> India</p>
        <p><i class="fas fa-envelope"></i> mohd_gufranbca2023@msit.edu.in</p>
        
        <form action="subscribe.jsp" method="post">
            <input type="email" name="email" placeholder="Enter your email" required>
            <button type="submit"><i class="fas fa-paper-plane"></i></button>
        </form>
    </div>

    <div class="footer-bottom">
        <hr>
        <p>&copy; <%= new java.util.Date().getYear() + 1900 %> Student Skill Management System. All Rights Reserved.</p>
    </div>

</footer>